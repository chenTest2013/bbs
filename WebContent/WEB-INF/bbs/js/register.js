//验证码更新
function changeValidateCode(obj) { 
	//获取当前的时间作为参数，无具体意义 
	var timenow = new Date().getTime(); 
	//每次请求需要一个不同的参数，否则可能会返回同样的验证码 
	//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 
	obj.src="rand.action?d="+timenow; 
	} 

//注册验证,用的是jquery validate插件
$(document).ready(
		
		function() {
			//username验证
			jQuery.validator.addMethod("strcheck", function(value, element) { 
				return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
				}, "只能包括中文字、英文字母、数字和下划线"); 
			// 邮箱格式验证 
			jQuery.validator.addMethod("emailcode", function(value, element) { 
			var email = /^[a-zA-Z0-9]{3,25}@([a-z]{2,25}|[0-9]{3,25}).com$/; 
			return this.optional(element) || (email.test(value)); 
			}, "邮箱格式错误,如123@123.com,123@qq.com");
			
			jQuery.validator.addMethod("pass", function(value, element) { 
				var pass = /^[\w]{6,15}$/; 
				return this.optional(element) || (pass.test(value)); 
				}, "只能包括数字,大小写字母和下划线"); 
			
			
			$('#regform').validate(
					{
						errorElement:"span" ,
						rules : {

							username : {
								
								minlength : 3,
								rangelength:[3,8],
								remote:"iSexistName",
								required : true,
								strcheck: true,
							},
							email : {
								
								emailcode:true,
								required : true,
								email : true,
								minlength : 8,
								remote:"iSexistEmail",
							},
							pwd : {
								rangelength:[6,15],
								pass:true,
								required : true,
								
							},
							pwd2 : {
								rangelength:[6,15],
								pass:true,
								equalTo:"#inputPassword",
								required : true,
								
							},
							
							sex : {
								required : true,
								
							},
								
							authcode : {
								required : true,
								remote:"checkcode"
								
							},	
							
						},
						//ignore: "#inlineRadio1",
						messages:{ 
							  username:{ 
								  remote:"该用户名已存在，请换个其他的用户名！" ,
								  minlength: "用户名不能少于3个字符",
							      required:"用户名不能为空！", 
							      
							      strcheck:"只能包括中文字、英文字母、数字和下划线啦"	  
							  }, 
							sex : {
								required : "请选择一个",
									
							},
							email : {
								minlength : "不支持过短的邮箱地址",
								remote:"该邮箱已被注册了",
									
							},  
							authcode : {
								
								remote:"验证码输错啦!",
									
							},  
						},
						
						highlight : function(element) {
							$(element).closest('.col-sm-5').removeClass(
									'text-success').addClass('error text-warning');
						},
						
						success : function(element) {
							
							element.text('OK!').addClass('valid').closest(
									'.col-sm-5').removeClass('error text-warning')
									.addClass('text-success');
						}
					});
			

		}
		




); // end document.ready