import CategoryEN from "../enumerations/CategoryEN";
import MovementTypeEN from "../enumerations/MovementTypeEN";
import StatusEN from "../enumerations/StatusEN";
import TypeEN from "../enumerations/TypeEN";

const Conversor = { 

  status: (containerStatus) => {    
    switch(containerStatus){
      case "CHEIO": {
        return StatusEN.CHEIO;
      }case "VAZIO": {
        return StatusEN.VAZIO;
      }  
    }
  },

  type: (containerType) => {    
    switch(containerType){
      case "VINTE": {
        return TypeEN.VINTE;
      }case "QUARENTA": {
        return TypeEN.QUARENTA;
      }  
    }
  },

  category: (containerCategory) => {    
    switch(containerCategory){
      case "IMPORTACAO": {
        return CategoryEN.IMPORTACAO;
      }case "EXPORTACAO": {
        return CategoryEN.EXPORTACAO;
      }  
    }
  },

  movementType: (movementType) =>{
    switch(movementType){
        case "EMBARQUE": {
          return MovementTypeEN.EMBARQUE;
        }case "DESCARGA": {
          return CategoryEN.DESCARGA;
        }case "GATEIN": {
            return CategoryEN.GATEIN;
        }case "GATEOUT": {
            return CategoryEN.GATEOUT;
        }case "POSICIONAMENTO": {
             return CategoryEN.POSICIONAMENTO;
        }case "PESAGEM": {
            return CategoryEN.PESAGEM;
        }case "SCANNER": {
            return CategoryEN.SCANNER;
        }       
      }
  }
}

export default Conversor