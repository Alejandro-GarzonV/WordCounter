@Total
Feature: Validar la funcionalidad del contador de palabras

    Background: el usuario navega e inserta el texto
        Given un usuario navega la pagina wordcounter.net

    Scenario Outline:Validar el recuento de palabras
        When el usuario ingresa el texto <texto>
        Then entonces visualiza el recuento de palabras en "44"
        Examples:
            | texto | 
            | "Si oyes en la noche la voz De la soledad y el rumor Que ha llegado el tiempo De ser dos... aqui estoy! Ten mi mano, aprietala bien Ten mi hombro, apoyate en el Y a donde nos lleve el viaje ire Contigo ire"|

    Scenario Outline:Validar el recuento de caracteres
        When el usuario ingresa el texto <texto>
        Then visualiza el recuento de caracteres en "204"
        Examples:
            | texto | 
            | "Si oyes en la noche la voz De la soledad y el rumor Que ha llegado el tiempo De ser dos... aqui estoy! Ten mi mano, aprietala bien Ten mi hombro, apoyate en el Y a donde nos lleve el viaje ire Contigo ire"|
