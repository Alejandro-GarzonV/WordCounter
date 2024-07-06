@Total
Feature: Validar la funcionalidad del contador de palabras

Scenario Outline:Validar el recuento de palabras
    Given un usuario navega la pagina wordcounter.net
    When el usuario ingresa el texto <texto>
    Then entonces visualiza el recuento de palabras en "44"
    Examples:
        | texto | 
        | "Si oyes en la noche la voz De la soledad y el rumor Que ha llegado el tiempo De ser dos... aqui estoy! Ten mi mano, aprietala bien Ten mi hombro, apoyate en el Y a donde nos lleve el viaje ire Contigo ire"|