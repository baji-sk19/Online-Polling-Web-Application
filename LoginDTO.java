package com.App.Polling.DTO;
import lombok.Data;
@Data
public class LoginDTO {
	
        private String userid;
		private String password;

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public LoginDTO(String userid, String password) {
			super();
			this.userid = userid;
			this.password = password;
		}

		@Override
		public String toString() { 
			return "LoginDto [userid=" + userid + ", password=" + password + "]";
		}

		public LoginDTO() {
			super();
		}



}
