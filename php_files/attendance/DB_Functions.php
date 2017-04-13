<?php

	class DB_Functions {
		
		private $Conn;
		
		//constructor
		function __construct(){
			
			require_once ('Connect.php'); 
			
			//connection to database	
			$db = new Connect();
			$this->conn = $db->connect();
		}
		
		// destructor
		function __destruct() {
         
		}
		
		///////////////////////////////// LOGIN SYSTEM /////////////////////////////
		
		
		// return username and password from db for teacher
		public function getuserData($username, $password){
			$push = $this->conn->prepare("SELECT * FROM teacher WHERE username = ? AND userpassword = ? ");
			$push->bind_param("ss", $username, $password);
			if ($push->execute()) {
				$user = $push->get_result()->fetch_assoc();
				$push->close();
				return $user;
            }else {
				return NULL;
			}
		}
		
		//check if user's data present in db using teacher
		public function checkifuserexisted($username){
			$check = $this->conn->prepare("SELECT username FROM teacher WHERE username = ?");
			$check->bind_param("s", $username);
			$check->execute();
			$check->store_result();
			if ($check->num_rows>0) {
				$check->close(); // user is existed
				return true;
            }else {
				return false; // user is not existed
			}
		}
		
	}
?>