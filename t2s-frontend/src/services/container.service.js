import API from "../t2s.api";

const ContainerService = {  

	findByContainerNumber: async(containerNumber) => {
		return API.get(`/container/${containerNumber}`);
	},	

	findAll: async() => {
		return API.get(`/container/`);
	},	

	save: async(container) => {
		return API.post(`/container/update/save`,container);
	},	

	delete: async(idContainer = 0) => {
		return API.post(`/container/update/delete`, idContainer);
	},

}

export default ContainerService
