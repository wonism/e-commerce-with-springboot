<!DOCTYPE html>
<html lang="en">
<%@ include file="/common/header.jsp"%>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">Please Sign In</h3>
          </div>
          <div class="panel-body">
            <form role="form" action="/admin/j_security_check" method="post">
              <fieldset>
                <div class="form-group">
                  <input class="form-control" placeholder="User Id" name="j_username">
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Password" name="j_password" type="password">
                </div>
                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@ include file="/common/scripts.jsp"%>
</body>

</html>
