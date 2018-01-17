<div class="logindetails">
		<h4>ACCOUNT LOGIN</h4>
		<div class="requiredInfo">to update your account information
			online or view your points balance, please log in below.</div>
		<br />
		<form:form id="loginForm" name="loginForm" action="login.do"
			method="POST">
			<fieldset>
				<table>
					<tr>
						<td colspan="2"><span class="asteriksInfo"> indicates
								mandatory field</span> <br /> <br /></td>
					</tr>
					<tr>
						<td>UserName / Email:</td>
						<td><input type="text" name="username" value=""></td>
						<td><span class="error_username"></span><br /> <br /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" value=""></td>
						<td><span class="error_password"></span><br /> <br /></td>
					</tr>
					<tr>
						<td colspan="3"><span class="error_response"> 
						

						</span> <br />
						<input type="submit" value="login" class="submitBtn"> <br />
						</td>
					</tr>
					<tr>
						<td><br /> <br /></td>
					</tr>
					<tr>
						<td colspan="2"><span class="asteriksInfo"> forgot
								user name or password? click here </span> <br /></td>
					</tr>
				</table>


				<br /> <br /> <br />
			</fieldset>

		</form:form>


	</div>