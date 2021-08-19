import API from "../t2s.api";

const ContainerService = {  

	findById: async(id = 0) => {
		return API.get(`/container/${id}`);
	},	

	findAll: async() => {
		return API.get(`/container/`);
	},	

	save: async(container) => {
		return API.post(`/container/save`,container);
	},	

	delete: async(idContainer = 0) => {
		return API.post(`/container/delete`, idContainer);
	},

}

export default ContainerService
