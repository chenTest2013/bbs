<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8;" />

<title>Insert title here</title>
<link href="./bootstrap-switch/css/bootstrapSwitch.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<SCRIPT src="./jquery/jquery-2.1.3.js"></SCRIPT>
<SCRIPT src="./bootstrap-switch/js/bootstrapSwitch.js"></SCRIPT>
<style>
.span4, h1 {
	text-align: center;
}

h1 {
	margin-bottom: 20px;
}

h3 {
	margin-top: 20px;
}
</style>
<META name="GENERATOR" content="MSHTML 11.00.9600.17496">
</head>
<BODY style="padding-top: 50px;">
	<DIV class="container">
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>Size</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch switch-large" data-on-label="开"
						data-off-label="关">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<DIV class="switch">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<DIV class="switch switch-small">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<DIV class="switch switch-mini">
						<INPUT type="checkbox" CHECKED>
					</DIV>
				</DIV>

			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>Colors</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch" data-off="info" data-on="primary">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<DIV class="switch" data-off="success" data-on="info">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<DIV class="switch" data-off="warning" data-on="success">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<DIV class="switch" data-off="danger" data-on="warning">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<DIV class="switch" data-off="primary" data-on="danger">
						<INPUT type="checkbox" CHECKED>
					</DIV>
				</DIV>

			</DIV>
		</DIV>

		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>Animation</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch" data-animated="false">
						<INPUT type="checkbox" CHECKED>
					</DIV>
				</DIV>
				<PRE class="prettyprint linenums">&lt;div class="switch" data-animated="false"&gt;
    &lt;input type="checkbox" checked /&gt;
&lt;/div&gt;</PRE>
			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>Disabled</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch">
						<INPUT disabled="" type="checkbox" CHECKED>
					</DIV>
				</DIV>
				<PRE class="prettyprint linenums">&lt;div class="switch"&gt;
   &lt;input type="checkbox" checked disabled /&gt;
&lt;/div&gt;</PRE>
			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>Text</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch" data-off-label="NO" data-on-label="SI">
						<INPUT type="checkbox" CHECKED>
					</DIV>
				</DIV>
				<PRE class="prettyprint linenums">&lt;div class="switch" data-on-label="SI" data-off-label="NO"&gt;
    &lt;input type="checkbox" checked /&gt;
&lt;/div&gt;</PRE>
			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>HTML text</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch" data-off-label="<i class='icon-remove'></i>"
						data-on-label="<i class='icon-ok icon-white'></i>">
						<INPUT type="checkbox" CHECKED>
					</DIV>
				</DIV>
				<PRE class="prettyprint linenums">&lt;div class="switch" data-on-label="&lt;i class='icon-ok icon-white'&gt;&lt;/i&gt;" data-off-label="&lt;i class='icon-remove'&gt;&lt;/i&gt;"&gt;
    &lt;input type="checkbox" checked /&gt;
&lt;/div&gt;</PRE>
			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>
					Event handler <SMALL>javascript</SMALL>
				</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch" id="mySwitch">
						<INPUT type="checkbox" CHECKED>
					</DIV>
				</DIV>
				<PRE class="prettyprint linenums">$('#mySwitch').on('switch-change', function (e, data) {
    var $el = $(data.el)
      , value = data.value;
    console.log(e, $el, value);
});</PRE>
			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>
					Toggle State <SMALL>javascript</SMALL>
				</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch" id="toggle-state-switch">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<BR> <BR>
					<DIV class="btn btn-primary" id="toggle-state-switch-button-on">ON!</DIV>
					<DIV class="btn btn-primary" id="toggle-state-switch-button">Toggle
						me!</DIV>
					<DIV class="btn btn-primary" id="toggle-state-switch-button-off">OFF!</DIV>
				</DIV>
				<PRE class="prettyprint linenums">$('#toggle-state-switch').bootstrapSwitch('toggleState');
$('#toggle-state-switch').bootstrapSwitch('setState', false); // true || false</PRE>
			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>
					Destroy <SMALL>javascript</SMALL>
				</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch" id="destroy-switch">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<BR> <BR>
					<BUTTON class="btn btn-danger" id="btn-destroy-switch">
						Destroy me!</BUTTON>
				</DIV>
				<PRE class="prettyprint linenums">$('#destroy-switch').bootstrapSwitch('destroy');</PRE>
			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>
					Disabled <SMALL>javascript</SMALL>
				</H3>
				<DIV class="bs-docs-example">
					<DIV class="switch" id="disable-switch">
						<INPUT type="checkbox" CHECKED>
					</DIV>
					<BR> <BR>
					<BUTTON class="btn" id="btn-is-active-switch">Is active?</BUTTON>
					<BUTTON class="btn" id="btn-toggle-activation-switch">
						Toggle activation!</BUTTON>
					<BUTTON class="btn" id="btn-disable-switch">Disable!</BUTTON>
					<BUTTON class="btn" id="btn-activate-switch">Activate!</BUTTON>
				</DIV>
				<PRE class="prettyprint linenums">$('#disable-switch').bootstrapSwitch('isActive');
$('#disable-switch').bootstrapSwitch('toggleActivation');
$('#disable-switch').bootstrapSwitch('setActive', false);  // true || false</PRE>
			</DIV>
		</DIV>
		<DIV class="row-fluid">
			<DIV class="span12">
				<H3>
					Form <SMALL>- try to use tab and space</SMALL>
				</H3>
				<DIV class="bs-docs-example">
					<FORM class="form-horizontal span8 offset2">
						<DIV class="control-group">
							<LABEL class="control-label" for="inputEmail">Email</LABEL>
							<DIV class="controls">
								<INPUT id="inputEmail" type="text" placeholder="Email">
							</DIV>
						</DIV>
						<DIV class="control-group">
							<LABEL class="control-label" for="notification1">Notification
								1</LABEL>
							<DIV class="controls">
								<DIV tabIndex="0" class="switch">
									<INPUT id="notification1" type="checkbox">
								</DIV>
							</DIV>
						</DIV>
						<DIV class="control-group">
							<LABEL class="control-label" for="notification1">Notification
								2</LABEL>
							<DIV class="controls">
								<DIV tabIndex="0" class="switch">
									<INPUT id="notification2" type="checkbox">
								</DIV>
							</DIV>
						</DIV>
					</FORM>
					<DIV class="clearfix"></DIV>
				</DIV>

			</DIV>
		</DIV>


	</DIV>

	<SCRIPT>
		window.prettyPrint && prettyPrint();
		$('#mySwitch').on('switch-change', function(e, data) {
			var $el = $(data.el), value = data.value;
			console.log(e, $el, value);
		});

		$('#toggle-state-switch-button').on('click', function() {
			$('#toggle-state-switch').bootstrapSwitch('toggleState');
		});

		$('#toggle-state-switch-button-on').on('click', function() {
			$('#toggle-state-switch').bootstrapSwitch('setState', true);
		});

		$('#toggle-state-switch-button-off').on('click', function() {
			$('#toggle-state-switch').bootstrapSwitch('setState', false);
		});

		$('#btn-destroy-switch').on('click', function() {
			$('#destroy-switch').bootstrapSwitch('destroy');
			$(this).remove();
		});

		$('#btn-is-active-switch').on('click', function() {
			alert($('#disable-switch').bootstrapSwitch('isActive'));
		});

		$('#btn-toggle-activation-switch').on('click', function() {
			$('#disable-switch').bootstrapSwitch('toggleActivation');
		});

		$('#btn-disable-switch').on('click', function() {
			$('#disable-switch').bootstrapSwitch('setActive', false);
		});

		$('#btn-activate-switch').on('click', function() {
			$('#disable-switch').bootstrapSwitch('setActive', true);
		});
	</SCRIPT>
</BODY>
</html>