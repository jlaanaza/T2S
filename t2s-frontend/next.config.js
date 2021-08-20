module.exports = {
	async rewrites() {
		return [		
			{
				destination: '/containers/containers',
				source: '/'
			},	
     		{
				destination: '/container/:container',
				source: '/conteiner/:container'
			},
			{
				destination: '/register-container/register-container',
				source: '/novo-conteiner'
			},			
		]
	},
	async redirects() {
		return [			
			{
				source: '/containers/containers',
				destination: '/',
				permanent: true
			},
     		{
				source: '/container/:container',
				destination: '/conteiner/:container',
				permanent: true
			},
			{
				source: '/register-container/register-containe',
				destination: '/novo-conteiner',
				permanent: true
			},				
		]
	}
}

