package com.icndb.endPoints;

public enum IncorrectEndPoints implements EndPoints {
	
	INCORRECT_END_POINTS_JOK {
		public String endPoint() {
			return "/jok";
		}
	},
	INCORRECT_END_POINTS_CATEGO {
		public String endPoint() {
			return "/catego";
		}
	},
	INCORRECT_END_POINTS_AFTER_JOKES {
		public String endPoint() {
			return "/jokes/qwerty";
		}
	};	

}
