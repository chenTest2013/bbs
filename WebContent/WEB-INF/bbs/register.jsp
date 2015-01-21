<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="./bbs/js/jquery.validate.js"></script>
<script src="./bbs/js/messages_zh.js"></script>
<script src="./bbs/js/register.js"></script>


<div class="row">
	<div class="col-sm-1"></div>
	<div class="col-sm-10 col-sm-offset-1">
 
		<form class="form-horizontal" role="form" action="reg" method="post"
			id="regform">


			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="username"
						placeholder="用户名" name="username" autofocus tabindex="1">
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail" class="col-sm-2 control-label">电子邮件</label>
				<div class="col-sm-5 parentCls">
					<input type="text" class="form-control inputElem" id="email"
						placeholder="电子邮件" name="email" tabindex="2">

				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="inputPassword"
						placeholder="密码" name="pwd" tabindex="3">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword2" class="col-sm-2 control-label">确认密码</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="inputPassword2"
						placeholder="确认密码" name="pwd2" tabindex="4">


				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<label class="radio-inline"> 
					<input type="radio" name="sex"
						id="inlineRadio1" value="男" tabindex="5"> 男
					</label> 
					<label class="radio-inline"> 
					<input type="radio"
						name="sex" id="inlineRadio2" value="女"> 女
					</label> <label class="radio-inline"> 
					<input type="radio"
						name="sex" id="inlineRadio0" value="保密"> 保密
					</label>
				</div>
			</div>



			<div class="form-group form-inline">
				<label for="authcode" class="col-sm-2 control-label">验证码</label>
				<div class="col-sm-5">
					<input class="form-control " type="text" id="authcode" name="authcode" MaxLength="4"
						tabindex="6" placeholder="验证码或者问题答案" /> <img
						id="JD_Verification1" src="rand"
						onclick="changeValidateCode(this)" title="点击图片刷新验证码"
						style="cursor: pointer; height: 30px;" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2  col-sm-10 btn-group">
					<div class="btn-group col-sm-3">
						<button type="submit" class="btn  btn-primary btn-lg btn-block"
							tabindex="7">注册</button>
					</div>

					<div class="btn-group col-sm-3">
						<button type="reset" class="btn  btn-success btn-lg btn-block"
							tabindex="8">重填</button>
					</div>

				</div>



			</div>

		</form>
	</div>

</div>






