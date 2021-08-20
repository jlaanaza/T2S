const base = () => {
	return "http://localhost:8080"
}

const headers  = new Headers({
	'Content-Type': 'application/json',
	"Access-Control-Allow-Origin":"*"

})


const API = {
	get: async (path = '', params = {}) => {
		
		let url = base() + path;	
		const method = 'GET';
		let response = await fetch(url, {method , params})
		return await response.json();		
		
	},
	

	post: async (path = '', params = {}, json = true) => {

		const url = base() + path;
		const method = 'POST';
		const body = JSON.stringify(params);

		const response = await fetch(url, {			
			method, headers, body
		})
		return await json ? response.json() : response;


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
