//FALTAM TESTEEEEEEEES

class Herois {
    constructor(array = []) { //1
        this.arrayDeHerois = new Array();
        for (let prop in array) {
            this.arrayDeHerois.push(array[prop]);
        }
    }

    foraDaGuerraCivil() { //2
        let arrayDosPacificos = new Array();
        return arrayDosPacificos = this.arrayDeHerois.filter(heroi =>
            heroi.events.items.filter(e => e.name.indexOf('Civil War') === -1));

        // A LA MAICON
        //arrayDosPacificos = arrayDeHerois.filter(heroi => );
        // for (let i; i < this.arrayDeHerois.length; i++) {
        // let eventos = this.arrayDeHerois[prop].events.items;
        // let heroiPacifico = true;
        // arrayDosPacificos = this.arrayDeHerois.filter(function (heroi) {
        //     for (let j = 0; j < heroi.events.items.length; j++) {
        //         if (heroi.events.items[j].name === 'Civil War') {
        //             heroiPacifico = false;
        //         }
        //     }
        //     if (heroiPacifico) {
        //         return heroi;
        //     }
        // });
        // for (let key in eventos) {
        //     let itemEvento = eventos[key];
        //     if (itemEvento.name === "Civil War") {
        //         heroiPacifico = false;
        //     }
        // }
        // if (heroiPacifico) {
        //     arrayDosPacificos.push(this.arrayDeHerois[prop]);
        // }
    }



    maisPublicado() { //3

        return this.arrayDeHerois.sort((heroi1, heroi2) => heroi2.comics.available - heroi1.comics.available)[0];

        // A LA MAICON
        //     let maiorQuantidade = 0;
        //     let heroiComMaisComics;
        //     for (let i = 0; i < this.arrayDeHerois.length; i++) {
        //         let heroi = this.arrayDeHerois[i];
        //         let numeroDeComics = heroi.comics.available;
        //         if (numeroDeComics > maiorQuantidade) {
        //             maiorQuantidade = numeroDeComics;
        //             heroiComMaisComics = heroi;
        //         }
        //     }
        //     return heroiComMaisComics;
    }


    mediaDePaginas() { //4

        let totalDePaginas = this.arrayDeHerois.reduce((acumulador, heroi) =>
            acumulador + heroi.comics.items.reduce((acumuladorComic, item) =>
                acumuladorComic + item.pageCount, 0), 0);

        return totalDePaginas / this.arrayDeHerois.length;

        // A LA MAICON
        // let mediaDePaginasDoHeroi = 0;
        // let mediaTotal = 0;
        // for (var prop in this.arrayDeHerois) {
        //     let quadrinhos = this.arrayDeHerois[prop].comics.items;
        //     for (var key in quadrinhos) {
        //         mediaDePaginasDoHeroi += quadrinhos[key].pageCount;
        //     }
        //     mediaDePaginasDoHeroi = mediaDePaginasDoHeroi / key;
        //     mediaTotal += mediaDePaginasDoHeroi;
        // }
        // return Math.round(mediaTotal / prop);
    }

    seriesPorLongevidade() { //5

        let todasSeries = this.arrayDeHerois.map(heroi => heroi.series.items)
            .reduce((acumulador, series) => acumulador.concat(series));

        return todasSeries.sort((elem1, elem2) => {
            let longevidade = elem1.endYear - elem1.startYear;
            let longevidadeASerComparada = elem2.endYear - elem2.startYear;
            return longevidadeASerComparada - longevidade;
        });

        // A LA MAICON
        // let seriesOrdenadas = [];
        // for (let i = 0; i < this.arrayDeHerois.length; i++) {
        //     let heroi = this.arrayDeHerois[i];
        //     let seriados = heroi.series.items;
        //     for (let key in seriados) {
        //         seriesOrdenadas.push(seriados[key]);
        //     }
        // }
        // var trocando = true;
        //BUBBLESORT :)
        // do{
        //     trocando = false;
        //     for (let i = 0; i < seriesOrdenadas.length - 1; i ++){
        //         let longevidade = seriesOrdenadas[i].endYear - seriesOrdenadas[i].startYear;
        //         let longevidadeASerComparada = seriesOrdenadas[i+1].endYear - seriesOrdenadas[i+1].startYear;
        //         let precisaTrocar = longevidade < longevidadeASerComparada;
        //         if (precisaTrocar){
        //             let serieATrocar = seriesOrdenadas[i];
        //             seriesOrdenadas[i] = seriesOrdenadas[i+1];
        //             seriesOrdenadas[i+1] = serieATrocar;
        //             trocando = true;
        //         }
        //     }

        // } while (trocando);
        // return seriesOrdenadas
    }

    comicMaisCara() {

        let todasComics = this.herois.map()

        // A LA MAICON
        //     let comicMaisCara;
        //     let precoComicMaisCara = 0;
        //     let somaPrecoComicsPorHeroi = 0;
        //     for (let i; heroi < this.arrayDeHerois.length; i++) {
        //         let heroi = this.arrayDeHerois[i];
        //         let somaPrecoComicsPorHeroi = heroi.comics.items.prices

        //         let quadrinhos = heroi.comics.items;
        //         for (let j = 0; j < quadrinhos.length; j++) {
        //             somaPrecoComicsPorHeroi += quadrinhos[j].prices[0].price;
        //         }
        //         if (somaPrecoComicsPorHeroi > precoComicMaisCara) {
        //             precoComicMaisCara = somaPrecoComicsPorHeroi;
        //             comicMaisCara = heroi.comics;
        //         }

        //     }
        //     return comicMaisCara;
        // }

    }

