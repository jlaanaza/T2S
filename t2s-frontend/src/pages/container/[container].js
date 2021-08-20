import Head from 'next/head'
import Image from 'next/image'
import CategoryEN from '../../enumerations/CategoryEN';
import StatusEN from '../../enumerations/StatusEN';
import TypeEN from '../../enumerations/TypeEN';
import ContainerService from '../../services/container.service';
import MovementService from '../../services/movement.service';
import Conversor from '../../utils/conversor';
import styles from './container.module.css'

export default function Container({container,movements}) {

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
        <p className={styles.description}>   Tipo do contêiner : {Conversor.type(container.type)}     </p>
        <p className={styles.description}>   Status : {Conversor.status(container.status)}     </p>
        <p className={styles.description}>   Categoria : {Conversor.category(container.category)}     </p>

        <div className="responsive-table">
      <table className="table">
        <thead>
          <tr>            
            <th className="text-left">Tipo de movimentação</th>
            <th className="text-left">Data de início da movimentação</th>
            <th className="text-center">Data do fim da movimentação</th>
          </tr>
        </thead>
        <tbody>
          {movements.map(( movement ) => {
            return (
              <tr key={movement.id}>               
                <td className="text-left">{Conversor.movementType(movement.movementType)}</td>
                <td className="text-left">{new Date(movement.startDate).toLocaleString()}</td>
                <td className="text-center">{new Date(movement.endDate).toLocaleString()}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
      </main>  
        
    </div>
  )
}
export async function getServerSideProps({ params }) {

	const container = await ContainerService.findByContainerNumber(params.container);

  const movements = await MovementService.findByContainerId(container.id);

	return {
		props: {
			container,
      movements
		}
	}
}

