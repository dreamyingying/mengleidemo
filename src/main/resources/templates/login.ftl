<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome - 请登录</title>

    <link href="${ctx}/quote/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/quote/css/login.css" rel="stylesheet">
    <link href="${ctx}/quote/css/style.css" rel="stylesheet">
</head>
<body class="signin">
        <div class="signinpanel">
            <div class="row">
                <div class="col-sm-12">
                    <form method="post" action="${ctx!}/admin/login" id="frm">
                        <h3 class="no-margins">请登录</h3>
                        <p class="m-t-md">欢迎进入家庭账务管理系统</p>
                        <input type="text" class="form-control uname" name="username" id="username" placeholder="用户名" style="margin-bottom: 30px;margin-top: 28px"/>
                        <input type="password" class="form-control pword m-b" name="password" id="password"  placeholder="密码" style="margin-bottom: 30px"/>
                        <button class="btn btn-success btn-block" id="form">登录</button>
                    </form>
                </div>
            </div>
            <div class="signup-footer">
                <div class="pull-left">
                    &copy; 版权所有 <b>孟磊</b>
                </div>
            </div>
        </div>
</body>
</html>