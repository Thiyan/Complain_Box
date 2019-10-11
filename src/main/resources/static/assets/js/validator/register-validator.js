$(function () {
    var $registerForm=$("#register");

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
                password:{
                    required:true,
                    minlength: 6
                },
                confirm_password:{
                    required:true,
                    equalTo:'#password'
                },
                contactNo:{
                    required:true,
                    minlength:10
                },
                city:{
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
                password:{
                    required:'Password field is required',
                    minlength: 'Give a strong a password'
                },
                confirm_password:{
                    required:'Password field is required',
                    equalTo:'Passwords are mismatching'
                },
                contactNo:{
                    required:"Contact number field is required",
                    minlength:"Not a valid number"
                },
                city:{
                    required:'City field is required'
                }
            }
        })
    }

    // $("#form_id").invalid(function () {
    //     $("#submit").attr("disable",true);
    // });
})