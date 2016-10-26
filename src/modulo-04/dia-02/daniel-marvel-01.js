//FALTAM TESTEEEEEEEES

class Herois {
    constructor(array = []) { //1
        this.arrayDeHerois = new Array();
        for (let prop in array) {
            this.arrayDeHerois.push(array[prop]);
        }
    }

    foraDaGuerraCivil() { //2 
        this.arrayDosPacificos = new Array();
        for (let prop in this.arrayDeHerois) {
            let heroi = this.arrayDeHerois[prop];
            let eventos = heroi.events.items;
            let heroiPacifico = true;
            for (let key in eventos) {
                let itemEvento = eventos[key];
                if (itemEvento.name === "Civil War") {
                    heroiPacifico = false;
                }
            }
            if (heroiPacifico) {
                this.arrayDosPacificos.push(this.arrayDeHerois[prop]);
            }
        }
        return this.arrayDosPacificos;
    }

    maisPublicado() { //3
        let maiorQuantidade = 0;
        let heroiComMaisComics;
        for (let i = 0; i < this.arrayDeHerois.length; i++) {
            let heroi = this.arrayDeHerois[i];
            let numeroDeComics = heroi.comics.available;
            if (numeroDeComics > maiorQuantidade) {
                maiorQuantidade = numeroDeComics;
                heroiComMaisComics = heroi;
            }
        }
        return heroiComMaisComics;
    }


    mediaDePaginas() { //4
        let mediaDePaginasDoHeroi = 0;
        let mediaTotal = 0;
        for (var prop in this.arrayDeHerois) {
            let quadrinhos = this.arrayDeHerois[prop].comics.items;
            for (var key in quadrinhos) {
                mediaDePaginasDoHeroi += quadrinhos[key].pageCount;
            }
            mediaDePaginasDoHeroi = mediaDePaginasDoHeroi / key;
            mediaTotal += mediaDePaginasDoHeroi;
        }
        return Math.round(mediaTotal / prop);
    }

    seriesPorLongevidade() { //5
        let seriesOrdenadas = [];
        for (let i = 0; i < this.arrayDeHerois.length; i++) {
            let heroi = this.arrayDeHerois[i];
            let seriados = heroi.series.items;
            for (let key in seriados) {
                seriesOrdenadas.push(seriados[key]);
            }
        }
        var trocando = true;

        seriesOrdenadas.sort(function (elem1, elem2) {
            let longevidade = elem1.endYear - elem1.startYear;
            let longevidadeASerComparada = elem2.endYear - elem2.startYear;
            return longevidadeASerComparada - longevidade;
        });

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
        return seriesOrdenadas;
    }

    comicMaisCara() {
        let comicMaisCara;
        let precoComicMaisCara = 0;
        let somaPrecoComicsPorHeroi = 0;
        for (let i; heroi < this.arrayDeHerois.length; i++) {
            let heroi = this.arrayDeHerois[i];
            let somaPrecoComicsPorHeroi = heroi.comics.items.prices

            // let quadrinhos = heroi.comics.items;
            // for (let key in quadrinhos){
            //     somaPrecoComicsPorHeroi += quadrinhos[key].prices[0].price;
            // }
            if (somaPrecoComicsPorHeroi > precoComicMaisCara) {
                precoComicMaisCara = somaPrecoComicsPorHeroi;
                comicMaisCara = heroi.comics;
            }

        }
        return comicMaisCara;
    }

}

