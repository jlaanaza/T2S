import axios from "axios";

const base = () => {
	return "http://localhost:8080"
}

const API = {
	get: async (path = '', params = {}) => {
		
		let url = base() + path;	
		const method = 'GET';
		let response = await fetch(url, {method , params})
		return await response.json();		
		
	},
	

	post: async (path = '', params = {}, isJson = true) => {
		return await doRequest(path, async () => {

			const url = base() + path;
			const method = 'POST';
			const body = isJson ? JSON.stringify(params) : params;
			let result = null
			const response = await fetch(url, {
				method, headers: headersNoAxios, body
			})

			try {
				result = await response.text();
				return JSON.parse(result)
			} catch (e) {
				return result
			}

		});
	},	
}

async function doRequest(url, callback) {

	try {

		const unknownStr = '[object Object]';
		if (url.includes(unknownStr))
			throw new Error('Unknown Object String');

		return await callback();

	} catch (e) {
		console.log("Error:", e.toString());
		return null;
	}

}

export default API
