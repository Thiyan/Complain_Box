$(function () {
    var $registerForm=$("#add-police");

    // $.validate.addMethod("noSpace",function (value,element) {
    //     return value==' ' || value.trim().length ==0
    // },"Spaces are not allowed");

    if($registerForm.length){
        $registerForm.validate({
            rules:{
                name:{
                    required:true,
                    noSpace:true
                },
                email:{
                    required:true,
                    email:true
                },
                contactNo:{
                    required:true,
                    minlength:10
                },
                city:{
                    required:true
                },
                gender:{
                    required:true
                }
            },
            messages:{
                name:{
                    required:'Name field is required',
                },
                email:{
                    required:'Email field is required',
                    email:'Not a valid email id'
                },
                contactNo:{
                    required:"Contact number field is required",
                    minlength:"Not a valid number"
                },
                city:{
                    required:'City field is required'
                },
                gender:{
                    required:'Gender is required'
                }
            }
        })
    }

    // $("#form_id").invalid(function () {
    //     $("#submit").attr("disable",true);
    // });
})