
import Almacenes.Almacen_Jugadores;
import Almacenes.Almacen_Palabras;
import Componentes_Rosco.Palabra;
import Personas.Jugador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author e.tamajon.2020
 */
public class Main {

    public static void main(String[] args) {
        Almacen_Palabras pruebaP = new Almacen_Palabras();
        Almacen_Jugadores pruebaJ = new Almacen_Jugadores();

        Palabra albaricoque = new Palabra("Albaricoque");
        albaricoque.addDefinicion("Fruta");
        pruebaP.addPalabra(albaricoque);

        Palabra barco = new Palabra("Barco");
        barco.addDefinicion("Vehiculo acuatico");
        pruebaP.addPalabra(barco);

        Palabra casco = new Palabra("Casco");
        casco.addDefinicion("Medida de protección");
        pruebaP.addPalabra(casco);

        Palabra dado = new Palabra("Dado");
        dado.addDefinicion("Utilizado en juegos de azar");
        dado.addDefinicion("Se utiliza en juegos de rol");
        pruebaP.addPalabra(dado);

        Palabra electron = new Palabra("Electrón");
        electron.addDefinicion("Perteneciente a los átomos");
        pruebaP.addPalabra(electron);

        Palabra fragancia = new Palabra("Fragancia");
        fragancia.addDefinicion("Sinonimo de perfume");
        pruebaP.addPalabra(fragancia);

        Palabra grado = new Palabra("Grado");
        grado.addDefinicion("Unidad de medida de temperatura");
        pruebaP.addPalabra(grado);

        Palabra hereje = new Palabra("Hereje");
        hereje.addDefinicion("Persona que va encontra de una religión");
        pruebaP.addPalabra(hereje);

        Palabra iluminacion = new Palabra("Iluminación");
        iluminacion.addDefinicion("Acción y efecto de iluminar");
        pruebaP.addPalabra(iluminacion);

        Palabra juglar = new Palabra("Juglar");
        juglar.addDefinicion("Aquel que cantaba cuentos místicos en la edad media");
        pruebaP.addPalabra(juglar);

        Palabra litrona = new Palabra("Litrona");
        litrona.addDefinicion("Cerveza de un litro");
        pruebaP.addPalabra(litrona);

        Palabra macaco = new Palabra("Macaco");
        macaco.addDefinicion("Tipo de mono");
        pruebaP.addPalabra(macaco);

        Palabra nicotina = new Palabra("Nicotina");
        nicotina.addDefinicion("Perteneciente a los cigarros");
        pruebaP.addPalabra(nicotina);

        Palabra orion = new Palabra("Orión");
        orion.addDefinicion("Constelación, conocida como \"El cazador\"");
        pruebaP.addPalabra(orion);

        Palabra progenie = new Palabra("Progenie");
        progenie.addDefinicion("Ascendencia");
        pruebaP.addPalabra(progenie);

        Palabra queso = new Palabra("Queso");
        queso.addDefinicion("Lácteo");
        queso.addDefinicion("Suele representarse con muchos agujeros");
        pruebaP.addPalabra(queso);

        Palabra rubidio = new Palabra("Rubidio");
        rubidio.addDefinicion("Elemento de la tabla periódica número 37");
        pruebaP.addPalabra(rubidio);

        Palabra sexenio = new Palabra("Sexenio");
        sexenio.addDefinicion("Periodo de seis años");
        pruebaP.addPalabra(sexenio);

        Palabra triangulo = new Palabra("Triángulo");
        triangulo.addDefinicion("Figura de tres lados");
        pruebaP.addPalabra(triangulo);

        Palabra urna = new Palabra("Urna");
        urna.addDefinicion("Almacen de votos");
        urna.addDefinicion("Donde se guarda a una persona despues de incinerarla");
        pruebaP.addPalabra(urna);

        Palabra vitaliceo = new Palabra("Vitalíceo");
        vitaliceo.addDefinicion("Para toda la vida");
        pruebaP.addPalabra(vitaliceo);

        Palabra xilofono = new Palabra("Xilófono");
        xilofono.addDefinicion("Instrumento musical");
        pruebaP.addPalabra(xilofono);

        Palabra yuca = new Palabra("Yuca");
        yuca.addDefinicion("Arbusto perenne");
        pruebaP.addPalabra(yuca);

        Palabra zorro = new Palabra("Zorro");
        zorro.addDefinicion("Animal de color naranja, con especial relevancia en la cultura japonesa");
        pruebaP.addPalabra(zorro);

        Palabra abuelo = new Palabra("Abuelo");
        abuelo.addDefinicion("Persona masculina que se encuentra dos generaciones por encima");
        abuelo.addDefinicion("Similar a la expresión: coger al vuelo");
        pruebaP.addPalabra(abuelo);

        Palabra astronauta = new Palabra("Astronauta");
        astronauta.addDefinicion("Profesión en la que se realizan expediciones en el espacio exterior");
        pruebaP.addPalabra(astronauta);

        Palabra basura = new Palabra("Basura");
        basura.addDefinicion("Desperdicio");
        basura.addDefinicion("Tambien se llama así al lugar de disposicion de desperdicios");
        pruebaP.addPalabra(basura);

        Palabra bateria = new Palabra("Batería");
        bateria.addDefinicion("Instrumento de percusion");
        bateria.addDefinicion("Forma alternativa de llamar a las pilas");
        pruebaP.addPalabra(bateria);

        Palabra casa = new Palabra("Casa");
        casa.addDefinicion("Hogar de una persona");
        pruebaP.addPalabra(casa);

        Palabra corona = new Palabra("Corona");
        corona.addDefinicion("Distintivo de la realeza");
        corona.addDefinicion("Se lleva en la cabeza");
        pruebaP.addPalabra(corona);

        Palabra dormir = new Palabra("Dormir");
        dormir.addDefinicion("Accion de descansar");
        dormir.addDefinicion("Se lleva a cabo con los ojos cerrados");
        pruebaP.addPalabra(dormir);

        Palabra descuartizar = new Palabra("Descuartizar");
        descuartizar.addDefinicion("Accion de separar en cachitos a un ser vivo");
        pruebaP.addPalabra(descuartizar);

        Palabra eureka = new Palabra("Eureka");
        eureka.addDefinicion("Expresion de exito");
        eureka.addDefinicion("Muy relacionado a cientificos");
        pruebaP.addPalabra(eureka);

        Palabra esquizofrenia = new Palabra("Esquizofrenia");
        esquizofrenia.addDefinicion("Enfermedad en la que se ven y escuchan cosas que no son");
        pruebaP.addPalabra(esquizofrenia);

        Palabra fraticidio = new Palabra("Fraticidio");
        fraticidio.addDefinicion("Delito que consiste en matar a un hermano");
        fraticidio.addDefinicion("En la biblia lo lleva a cabo Cain");
        pruebaP.addPalabra(fraticidio);

        Palabra finall = new Palabra("Final");
        finall.addDefinicion("Ultima parte de algo");
        pruebaP.addPalabra(finall);

        Palabra grasa = new Palabra("Grasa");
        grasa.addDefinicion("Sustancia organica que se encuentra en el tejido adiposo");
        grasa.addDefinicion("El exceso de esta suele estar relacionado con el sobrepeso");
        pruebaP.addPalabra(grasa);

        Palabra grotesco = new Palabra("Grotesco");
        grotesco.addDefinicion("Que produce risa o burla por buscar lo ridículo, extravagante o absurdo");
        grotesco.addDefinicion("Relacionado con lo desagradable");
        pruebaP.addPalabra(grotesco);

        Palabra hiena = new Palabra("Hiena");
        hiena.addDefinicion("Animal que se dice: se rie de todo");
        pruebaP.addPalabra(hiena);

        Palabra hora = new Palabra("Hora");
        hora.addDefinicion("Conjunto de 60 segundos");
        pruebaP.addPalabra(hora);

        Palabra inundacion = new Palabra("Inundacion");
        inundacion.addDefinicion("Cuando el agua se acumula en exceso llegando a cubrir el suelo");
        inundacion.addDefinicion("Dios nos mando una y se quedó corto");
        pruebaP.addPalabra(inundacion);

        Palabra innato = new Palabra("Innato");
        innato.addDefinicion("Que no es aprendido y pertenece a la naturaleza de un ser desde su origen o nacimiento");
        pruebaP.addPalabra(innato);

        Palabra japon = new Palabra("Japon");
        japon.addDefinicion("Pais que recibió dos bombas atómicas");
        pruebaP.addPalabra(japon);

        Palabra ladron = new Palabra("Ladron");
        ladron.addDefinicion("Persona que hurta");
        pruebaP.addPalabra(ladron);

        Palabra mesa = new Palabra("Mesa");
        mesa.addDefinicion("Mueble en el que se ponen elementos encima");
        mesa.addDefinicion("Me sa lio rana la pista");
        pruebaP.addPalabra(mesa);

        Palabra marron = new Palabra("Marron");
        marron.addDefinicion("Color de la madera");
        pruebaP.addPalabra(marron);

        Palabra norma = new Palabra("Norma");
        norma.addDefinicion("Que debe seguirse");
        norma.addDefinicion("Infringirla lleva consecuencias");
        pruebaP.addPalabra(norma);

        Palabra ostentoso = new Palabra("Ostentoso");
        ostentoso.addDefinicion("Que llama mucho la atencion");
        pruebaP.addPalabra(ostentoso);

        Palabra proletariado = new Palabra("Proletariado");
        proletariado.addDefinicion("Conjunto de los trabajadores");
        pruebaP.addPalabra(proletariado);

        Palabra pan = new Palabra("Pan");
        pan.addDefinicion("Alimento que acompaña a muchas comidas");
        pan.addDefinicion("Suele resultar letal para los celiacos");
        pruebaP.addPalabra(pan);

        Palabra quirofano = new Palabra("Quirofano");
        quirofano.addDefinicion("Lugar de realizacion de operaciones");
        pruebaP.addPalabra(quirofano);

        Palabra rata = new Palabra("Rata");
        rata.addDefinicion("Roedor de un tamaño medio considerado una plaga");
        rata.addDefinicion("Hace unos años se llamaba asi tambien a los niños que jugaban videojuegos");
        pruebaP.addPalabra(rata);

        Palabra socrates = new Palabra("Socrates");
        socrates.addDefinicion("Filosofo griego");
        socrates.addDefinicion("Si no la sabes, podrias decir: Solo sé que no sé nada");
        pruebaP.addPalabra(socrates);

        Palabra trampa = new Palabra("Trampa");
        trampa.addDefinicion("Instrumento o artificio que se utiliza para cazar animales");
        trampa.addDefinicion("Plan o acción que tiene como fin engañar a una persona");
        pruebaP.addPalabra(trampa);

        Palabra uno = new Palabra("Uno");
        uno.addDefinicion("Primer numero despues del cero (letra)");
        uno.addDefinicion("numero anterior al dos");
        pruebaP.addPalabra(uno);

        Palabra venganza = new Palabra("Venganza");
        venganza.addDefinicion("Satisfacción que se toma del agravio o daño recibidos");
        pruebaP.addPalabra(venganza);

        Palabra wario = new Palabra("Wario");
        wario.addDefinicion("Personaje de la saga mario");
        pruebaP.addPalabra(wario);

        Palabra xavier = new Palabra("Xavier");
        xavier.addDefinicion("Como se llamaba el profesor de los X-men");
        xavier.addDefinicion("Sonoramente es similar a saber algo");
        pruebaP.addPalabra(xavier);

        Palabra yegua = new Palabra("Yegua");
        yegua.addDefinicion("Hembra del caballo");
        pruebaP.addPalabra(yegua);

        Palabra zangano = new Palabra("Zangano");
        zangano.addDefinicion("Abeja macho, cuya función es fecundar a la abeja reina");
        pruebaP.addPalabra(zangano);

        Palabra arbol = new Palabra("Arbol");
        arbol.addDefinicion("Planta caractelizada por tener un tronco y unas hojas en la copa");
        pruebaP.addPalabra(arbol);

        Palabra bomba = new Palabra("Bomba");
        bomba.addDefinicion("Elemento explosivo");
        bomba.addDefinicion("Japon recibió dos");
        pruebaP.addPalabra(bomba);

        Palabra corazon = new Palabra("Corazon");
        corazon.addDefinicion("Organo que impulsa sangre por el cuerpo");
        pruebaP.addPalabra(corazon);

        Palabra dragon = new Palabra("Dragon");
        dragon.addDefinicion("Criatura mitologica similar a un lagartija");
        pruebaP.addPalabra(dragon);

        Palabra envolver = new Palabra("envolver");
        envolver.addDefinicion("Cubrir un objeto de algo");
        envolver.addDefinicion("Se hace con los regalos");
        pruebaP.addPalabra(envolver);

        Palabra frances = new Palabra("Frances");
        frances.addDefinicion("Su comida favorita es la baggette");
        frances.addDefinicion("Su vocablo se basa en la palabra Oui");
        pruebaP.addPalabra(frances);

        Palabra girasol = new Palabra("Girasol");
        girasol.addDefinicion("Acción físicamente imposible que consiste en girar un astro");
        girasol.addDefinicion("Una flor se llama así");
        pruebaP.addPalabra(girasol);

        Palabra hierofante = new Palabra("Hierofante");
        hierofante.addDefinicion("Una carta del tarot");
        hierofante.addDefinicion("Conocido por ser verde");
        pruebaP.addPalabra(hierofante);

        Palabra igualdad = new Palabra("Igualdad");
        igualdad.addDefinicion("No");
        igualdad.addDefinicion("Proceso por el cual dos personas se hayan en la misma condición");
        pruebaP.addPalabra(igualdad);

        Palabra jamon = new Palabra("Jamon");
        jamon.addDefinicion("Pata del cerdo");
        pruebaP.addPalabra(jamon);

        Palabra largo = new Palabra("Largo");
        largo.addDefinicion("Contrario de corto");
        pruebaP.addPalabra(largo);

        Palabra manco = new Palabra("Manco");
        manco.addDefinicion("Persona a la que le falta una o mas manos");
        manco.addDefinicion("Suele jugar Yasuo");
        pruebaP.addPalabra(manco);

        Palabra narcisista = new Palabra("Narcisista");
        narcisista.addDefinicion("Persona que se tiene en demasiada alta estima");
        pruebaP.addPalabra(narcisista);

        Palabra o = new Palabra("O");
        o.addDefinicion("Cuarta vocal");
        pruebaP.addPalabra(o);

        Palabra papa = new Palabra("Papa");
        papa.addDefinicion("Patata latina");
        papa.addDefinicion("Se cayó el otro día");
        pruebaP.addPalabra(papa);

        Palabra quimera = new Palabra("Quimera");
        quimera.addDefinicion("Monstruo fabuloso que se representa con cabeza de león, cuerpo de cabra y cola de dragón");
        pruebaP.addPalabra(quimera);

        Palabra rico = new Palabra("Rico");
        rico.addDefinicion("Bueno en lo referente a comida");
        rico.addDefinicion("Acaudalado");
        pruebaP.addPalabra(rico);

        Palabra sombra = new Palabra("Sombra");
        sombra.addDefinicion("Se proyecta ante la existencia de la luz");
        pruebaP.addPalabra(sombra);

        Palabra tambor = new Palabra("Tambor");
        tambor.addDefinicion("Instrumento de percusión");
        pruebaP.addPalabra(tambor);

        Palabra unga = new Palabra("Unga");
        unga.addDefinicion("Onomatopella prehistórica");
        pruebaP.addPalabra(unga);

        Palabra victoria = new Palabra("Victoria");
        victoria.addDefinicion("Expresion de exito en un desafio");
        pruebaP.addPalabra(victoria);

        Palabra whisky = new Palabra("Whisky");
        whisky.addDefinicion("Bebida alcohólica de alta graduación que se obtiene por destilación de cebada y otros cereales");
        pruebaP.addPalabra(whisky);

        Palabra xenofobia = new Palabra("Xenofobia");
        xenofobia.addDefinicion("Rechazo a los extranjeros");
        pruebaP.addPalabra(xenofobia);

        Palabra yacimiento = new Palabra("Yacimiento");
        yacimiento.addDefinicion("Lugar en el que se encuentran restos arqueológicos");
        pruebaP.addPalabra(yacimiento);

        Palabra zoo = new Palabra("Zoo");
        zoo.addDefinicion("Lugar donde se exponen animales");
        pruebaP.addPalabra(zoo);

        Palabra alb = new Palabra("Arpa");
        alb.addDefinicion("Intrsumento de cuerda");
        pruebaP.addPalabra(alb);

        Palabra baco = new Palabra("Buzon");
        baco.addDefinicion("deposito de cartas");
        pruebaP.addPalabra(baco);

        Palabra caso = new Palabra("Coco");
        caso.addDefinicion("fruta homicida");
        pruebaP.addPalabra(caso);

        Palabra ddo = new Palabra("Dictador");
        ddo.addDefinicion("hitler");
        ddo.addDefinicion("franco");
        pruebaP.addPalabra(ddo);

        Palabra elecron = new Palabra("Electrocardiograma");
        elecron.addDefinicion("Representacion del latido");
        pruebaP.addPalabra(elecron);

        Palabra fragncia = new Palabra("Fardo");
        fragncia.addDefinicion("Comida tradicional gallega");
        pruebaP.addPalabra(fragncia);

        Palabra grdo = new Palabra("Gwyn");
        grdo.addDefinicion("plin plin plon");
        grdo.addDefinicion("jefe final dark souls");
        pruebaP.addPalabra(grdo);

        
        
        Jugador caballo = new Jugador("caballo", "deLasMontañas");
        pruebaJ.addJugador(caballo);

        Jugador ajolote = new Jugador("ajolote", "1234");
        pruebaJ.addJugador(ajolote);

        Jugador Lemniscomys = new Jugador("raton", "grassMouse");
        pruebaJ.addJugador(Lemniscomys);

        Jugador hipo = new Jugador("hipopotamo", "tuMadre");
        pruebaJ.addJugador(hipo);

        pruebaP.guardarAlmacen("almacen_palabras.ser");
        pruebaJ.guardarAlmacen("almacen_jugadores.ser");
    }

}
