import Head from "next/head";
import { useForm } from "react-hook-form";
import CategoryEN from "../../enumerations/CategoryEN";
import StatusEN from "../../enumerations/StatusEN";
import TypeEN from "../../enumerations/TypeEN";
import ContainerService from "../../services/container.service";
import styles from './register-container.module.css'

import { toast, ToastContainer } from 'react-toastify';

export default function RegisterContainer() {

 
  const { register, handleSubmit, formState: { errors } } = useForm();
  const onSubmit = data =>{
      ContainerService.save(data).then((response) => {   
        
        if(response != undefined && response.id !== undefined){     
           toast.success('Enviado com Sucesso')
        }else{
          toast.error("Ocorreu um erro!")
        }
      })
  } 
  return (
    <div className={styles.container}>    
      <Head>
      <title>T2S - Containers</title>
      <link rel="icon" href="/favicon.ico" />
      </Head> 
        <form onSubmit={handleSubmit(onSubmit)}>
          <ToastContainer             
            draggable={false}    
          />
          <p>Nome do cliente *</p>
          <input id="client" {...register('client', { required: true, minLength: 2 })} />
          {errors.client && errors.client?.type === "required" && <span>Este campo é obrigatório</span>}
          {errors.client && errors.client?.type === "minLength" && <span>Tem que ter no mínimo 2 caracteres</span> }
          <p>Número do container *</p>   
          <input placeholder="KHUY1234567" {...register("containerNumber", { required: true })} />
         
          {errors.containerNumber && errors.containerNumber?.type === "containerNumber" && <span>Este campo é obrigatório</span>}
          
          <p>Tipo do container * </p>  
          <select {...register("type", { required: true })}>  
              {Object.keys(TypeEN).map(key => (
              <option key={key} value={key}>
                {TypeEN[key]}
              </option>
            ))}
          </select>


          <p>Status do Container</p>

          <select {...register("status", { required: true })}>  
              {Object.keys(StatusEN).map(key => (
              <option key={key} value={key}>
                {StatusEN[key]}
              </option>
            ))}
          </select>


          <p>Categoria do Container</p>

          <select {...register("category", { required: true })}>  
              {Object.keys(CategoryEN).map(key => (
              <option key={key} value={key}>
                {CategoryEN[key]}
              </option>
            ))}
          </select>

          <input className={styles.button} type="submit" />
        </form>
    </div>
  );
	
}
