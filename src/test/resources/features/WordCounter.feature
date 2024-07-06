Feature: Validar la funcionalidad del contador de palabras

Scenario: Validar el recuento de palabras
    Given un usuario navega la pagina wordcounter.net
    When el usuario ingresa el texto <texto>
    Then entonces visualiza el recuento de palabras en 44
    Examples:
        | texto | 
        | Si oyes en la noche la voz De la soledad y el rumor Que ha llegado el tiempo De ser dos... ¡aquí estoy! Ten mi mano, apriétala bien Ten mi hombro, apóyate en él Y a donde nos lleve el viaje iré Contigo iré|