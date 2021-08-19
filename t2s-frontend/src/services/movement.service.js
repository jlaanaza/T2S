import API from "../t2s.api";

const MovementService = {  

	findById: async(id = 0) => {
		return API.get(`/movement/${id}`);
	},	
	
	findAll: async() => {
		return API.get(`/movement/`);
	},	

	save: async(movement) => {
		return API.post(`/movement/save`,movement);
	},	

	delete: async(idMovement = 0) => {
		return API.post(`/movement/delete`, idMovement);
	},	
}

export default MovementService
