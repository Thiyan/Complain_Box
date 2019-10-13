package YANmakes.complain.controllers;

import YANmakes.complain.services.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FileController {

    @Autowired
    private ComplainService complainService;

    @RequestMapping(value = "/get-file", method = RequestMethod.GET)
    public void getFile(HttpServletResponse response, @RequestParam("id") int id) {

        String fileUrl=complainService.getComplain(id).getFile();

        try {
            // get your file as InputStream

            File file = new File(fileUrl);
            InputStream is = new FileInputStream(file);

            // copy it to response's OutputStream
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            // log.info("Error writing file to output stream. Filename was '{}'", "a", ex);
            throw new RuntimeException("IOError writing file to output stream");
        }

    }
}
