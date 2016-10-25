class Herois {
    constructor(array = []) {
        this.arrayDeHerois = new Array();
        for (let i = 0; i < array.length; i++) {
            this.arrayDeHerois.push(array[i]);
        }
    }
}