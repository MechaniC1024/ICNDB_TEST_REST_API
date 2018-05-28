package com.icndb.endPoints;

public enum CorrectEndPoints implements EndPoints {

	CATEGORIES {
		public String endPoint() {
			return "/categories";
		}
	},
	JOKES {
		public String endPoint() {
			return "/jokes";
		}
	},
	ID_JOKE {
		public String endPoint() {
			return "jokes/{id}";
		}

	},
	COUNT_OF_JOKES {
		public String endPoint() {
			return "/jokes/count";
		}
	},
	RANDOM_JOKE {

		public String endPoint() {
			return "/jokes/random";
		}

	},
	RANDOM_JOKES {

		public String endPoint() {
			return "/jokes/random/{count}";
		}

	};

}
