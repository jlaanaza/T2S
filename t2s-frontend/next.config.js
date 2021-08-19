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
			}				
		]
	}
}

