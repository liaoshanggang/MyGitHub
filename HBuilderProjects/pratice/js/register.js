/*Email 验证: 字母或数字任意@字母或数字.域名后缀(2,14) */
function checkEmail() {
	var pattern = /^[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z]{2,14}(.[A-Za-z]{2,14})?$/;
	var email = document.getElementById("email").value;
	if(pattern.test(email)) {
		document.getElementById("emailFeedback").innerHTML = "邮箱正确";
	} else {
		document.getElementById("emailFeedback").innerHTML = "邮箱不正确，请重新输入！";
	}
}
/*用户名验证：8-16位的任意的英文、数字、中文、-(短横线)、_(下划线) */
function checkUsername() {
	var pattern = /[A-Za-z0-9_\-\u4e00-\u9fa5]{8,16}/;
	var username = document.getElementById("username").value;
	if(pattern.test(username)) {
		document.getElementById("usernameFeedback").innerHTML = "用户名正确";
	} else {
		document.getElementById("usernameFeedback").innerHTML = "用户名不正确，,请重新输入！";
	}
}
/*国内手机号验证: 13位手机号码*/
function checkPhoneNumber() {
	var pattern = /^13\d{9}$/;
	var phonenumber = document.getElementById("phonenumber").value;
	if(pattern.test(phonenumber)) {
		document.getElementById("phoneFeedback").innerHTML = "手机号正确";
	} else {
		document.getElementById("phoneFeedback").innerHTML = "手机号不正确，,请重新输入！";
	}
}
/*密码设置至少6位*/
function checkPwd() {
	var pattern = /^.{6,}$/;
	var pwd = document.getElementById("pwd").value;
	if(pattern.test(pwd)) {
		document.getElementById("pwdFeedback").innerHTML = "密码正确";
	} else {
		document.getElementById("pwdFeedback").innerHTML = "密码不正确,密码设置至少6位,请区分大小写！";
	}
}
/*验证确认密码*/
function checkRepwd() {
	var repwd = document.getElementById("repwd").value;
	if(repwd != document.getElementById("pwd").value) {
		document.getElementById("repwdFeedback").innerHTML = "两次输入密码不一致，请重新输入！";
	} else {
		document.getElementById("repwdFeedback").innerHTML = "两次输入密码正确！";
	}
}

/*日期验证：2017-12-31 */
function checkDate() {
	var pattern = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
	var date = document.getElementById("date").value;
	if(pattern.test(date)) {
		document.getElementById("dateFeedback").innerHTML = "日期正确";
	} else {
		document.getElementById("dateFeedback").innerHTML = "日期不正确，请重新输入！";
	}
}

/*身份证验证：18位长，前面17位数字，最后一位数字或x*/
function checkIdCard() {
	var pattern = /^\d{17}[\d|x]$/;
	var id = document.getElementById("identityCard").value;
	if(pattern.test(id)) {
		document.getElementById("idCardFeedback").innerHTML = "身份证正确";
	} else {
		document.getElementById("idCardFeedback").innerHTML = "身份证不正确，请重新输入！";
	}
}

function register(){
	alert("Nothing!");
}
