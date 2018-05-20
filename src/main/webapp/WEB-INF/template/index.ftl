<html>
<head >
    <title>简易增删改查3.0</title>
    <meta charset="utf-8">
    <style>
        .username.ng-valid {
            background-color: lightgreen;
        }
        .username.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .username.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }

        .email.ng-valid {
            background-color: lightgreen;
        }
        .email.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .email.ng-dirty.ng-invalid-email {
            background-color: yellow;
        }

    </style>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script>
        $(function(){
            $("#add").click(function(){
                if($("#username").val()==""){
                    $("#uerror").html("必须输入用户名！");
                    return ;
                }
                if($("#password").val()==""){
                    $("#perror").html("必须输入密码！");
                    return ;
                }

                document.all.myForm.submit();
            });
        });


    </script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link href="css/app.css" rel="stylesheet"/>
</head>
<body>
<div class="generic-container" >
    <div class="panel panel-default" >
        <div class="panel-heading"><span class="lead">请开始你的表演 </span></div>
        <div class="formcontainer">

            <form  name="myForm" class="form-horizontal" id="form1"
                   action="user"
                   method="post">
            <#--<%-->
            <#--User user1=(User)request.getAttribute("user");-->
            <#--%>-->


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">姓&nbsp&nbsp&nbsp&nbsp名</label>
                        <div class="col-md-7">
                            <input type="hidden" name="id"
                                   value="<#if user??>${user.id?c}</#if>"/>
                            <input type="hidden" name="action"
                                   value="<#if user??>edit<#else>add</#if>"/>
                            <input type="text" name="username" id="username"
                                   value='<#if user??>${user.username}</#if>'
                                   class="username form-control input-sm"
                                   placeholder="输入你的姓名"/>
                            <div class="has-error">
                                <span id="uerror"></span>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" >密&nbsp&nbsp&nbsp&nbsp码</label>
                        <div class="col-md-7">
                            <input type="text" name="password" id="password"
                                   value='<#if user??>${user.password}</#if>'
                                   class="password form-control input-sm"
                                   placeholder="输入你的密码"
                            />
                            <div class="has-error" >
                                <span id="perror"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="button" id="add"
                               value="提交"
                               class="btn btn-primary btn-sm">
                        <button type="reset" id="rst"
                                class="btn btn-warning btn-sm">复原</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">用户列表 </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><font color="red">ID.</font></th>
                    <th><font color="red">用户名</font></th>
                    <th><font color="red">密码</font></th>
                    <th width="20%"><font color="red">操作</font></th>
                </tr>
                </thead>
                <tbody>
                <#list users as user1>

                <tr>
                    <td>
                    <font color="#00ffff">${user1_index+1}</font>
                    </td>
                    <td>
                    ${user1.username}

                    </td>
                    <td>
                    ${user1.password}
                    </td>
                    <td>
                        <a href="user?action=queryid&id=${user1.id?c}"  class="btn btn-success custom-width">编辑</a>
                        <a href="user?action=del&id=${user1.id?c}"  class="btn btn-danger custom-width">删除</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>
