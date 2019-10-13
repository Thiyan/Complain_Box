$(function () {
    var $registerForm=$("#complain-form");

    // $.validate.addMethod("noSpace",function (value,element) {
    //     return value==' ' || value.trim().length ==0
    // },"Spaces are not allowed");

    if($registerForm.length){
        $registerForm.validate({
            rules:{
                subject:{
                    required:true,
                    noSpace:true
                },
                location:{
                    required:true,
                },
                description:{
                    required:true,
                }
            },
            messages:{
                subject:{
                    required:'Subject field is required'
                },
                location:{
                    required:'Location field is required'
                },
                description:{
                    required:"Contact number field is required"
                }
            }
        })
    }

    // $("#form_id").invalid(function () {
    //     $("#submit").attr("disable",true);
    // });
})