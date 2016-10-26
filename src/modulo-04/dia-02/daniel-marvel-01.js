class Herois {
    constructor(array = []) {
        this.arrayDeHerois = new Array();
        for (let prop in array) {
            this.arrayDeHerois.push(array[prop]);
        }
    }

    foraDaGuerraCivil() {
        this.arrayDosPacificos = [];
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
}
