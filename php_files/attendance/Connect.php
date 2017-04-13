<?php

	class Connect {
		
		private $Conn;
	
		//function to connect to database
		public function connect(){
			
			require_once ('Config.php'); // access constant value from config file, require_once helps to produce fatal error
			
			//connect to connection
			$this->Conn = mysqli_connect(HOST, USERNAME, PASS, DBNAME);
			
			return $this->Conn; //return connection
		}
	}
	

?>