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

        <p className={styles.description}>
              {containers.map((container) => (  
                <Link href={`/conteiner/${container.id}`}>
                <a>
                  <span >{container.containerNumber}</span>
    
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

