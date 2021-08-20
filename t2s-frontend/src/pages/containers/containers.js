import Head from 'next/head'
import Image from 'next/image'
import ContainerService from '../../services/container.service';
import styles from './containers.module.css'
import Link from 'next/link'


export default function Home({containers}) {

  return (
    <div className={styles.container}>    
    <Head>
      <title>T2S - Containers</title>
      <link rel="icon" href="/favicon.ico" />
    </Head> 

      <main className={styles.main}>
        <h1 className={styles.title}>
          T2S
        </h1>  

        <Link href="/novo-conteiner"> 
            <a className={styles.button}>Novo container </a>
        </Link>      

        <p className={styles.description}>
              {containers.map((container) => (  
                <Link href={`/conteiner/${container.containerNumber}`}>
                <a>
                  <p >{container.containerNumber}</p>
    
                </a>
              </Link>    
                 
            ))}
              
        </p>
      </main>  
        
    </div>
  )
}
export async function getServerSideProps() {

	const containers = await ContainerService.findAll();

	return {
		props: {
			containers
		}
	}
}

