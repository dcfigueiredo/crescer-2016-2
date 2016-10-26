class Herois {
    constructor(array = []) { //1
        this.arrayDeHerois = new Array();
        for (let prop in array) {
            this.arrayDeHerois.push(array[prop]);
        }
    }

    foraDaGuerraCivil() { //2 
        this.arrayDosPacificos = new Array();
        for (let prop in this.arrayDeHerois){
            let heroi = this.arrayDeHerois[prop];
            let eventos = heroi.events.items;
            let heroiPacifico = true;
            for (let key in eventos){
                let itemEvento = eventos[key];         
                console.log(itemEvento.name);       
                if (itemEvento.name === "Civil War"){
                    heroiPacifico = false;
                }
            }
            if (heroiPacifico){
                this.arrayDosPacificos.push(this.arrayDeHerois[prop]);
            }
        }
        return this.arrayDosPacificos;
    }

    maisPublicado (){ //3
        let maiorQuantidade = 0;
        let heroiComMaisComics;
        for (let prop in this.arrayDeHerois){
            let heroi = this.arrayDeHerois[prop];
            let numeroDeComics = heroi.comics.available;
            if (numeroDeComics > maiorQuantidade){
                maiorQuantidade = numeroDeComics;
                heroiComMaisComics = heroi;
            }
        }
        return heroiComMaisComics;
    }
}
