import Head from 'next/head'
import Image from 'next/image'
import ContainerService from '../../services/container.service';
import styles from './container.module.css'

export default function Container({container}) {

  return (
    <div className={styles.container}>     
      <Head>
      <title>T2S - Containers</title>
      <link rel="icon" href="/favicon.ico" />
    </Head> 
      <main className={styles.main}>
        <h1 className={styles.title}>
          Contêiner
        </h1>

        <p className={styles.description}>   Número do contêiner :  {container.containerNumber}      </p>
        <p className={styles.description}>   Cliente : {container.client}     </p>
        <p className={styles.description}>   Tipo do contêiner : {container.type}     </p>
        <p className={styles.description}>   Status : {container.status}     </p>
        <p className={styles.description}>   Categoria : {container.category}     </p>
      </main>  
        
    </div>
  )
}
export async function getServerSideProps({ params }) {

	const container = await ContainerService.findById(params.container);

	return {
		props: {
			container
		}
	}
}

