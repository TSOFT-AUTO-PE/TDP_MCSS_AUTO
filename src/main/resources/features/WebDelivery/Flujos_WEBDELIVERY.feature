Feature: FlujoWEB_DELIVERY


  @CREAR_PEDIDO
  Scenario Outline: Crear Pedido_ALTA_MASIVA_CAEQ_MASIVO
    Given INGRESAMOS A LA URL DE WEB DELIVERY "<caso_prueba>"
    When INGRESAMOS USUARIO A WEB DELIVERY"<caso_prueba>"
    And INGRESAMOS CONTRASEÑA A WEB DELIVER"<caso_prueba>"
    Then CLICK BOTON LOGIN INGRESANDO CORRECTAMENTE A LA PAGINA
    Given SELECCIONAMOS EL TIPO DE ALTA "<caso_prueba>"
    When INGRESAMOS DATOS SOLICITADOS "<caso_prueba>"
    Then CLICK EN BOTON SIGUIENTE
    And WIC_SCORE MCSS "<caso_prueba>"
    Given INGRESAMOS NUMERO DE IMEI "<caso_prueba>"
    When COMPRAMOS EQUIPO
    And SELECCIONAMOS PLAN "<caso_prueba>"
    And SELECCIONAMOS NUMERO
    And CREAMOS NUEVA CUENTA DE FACTURACION "<caso_prueba>"
    Given CLICK BOTON GENERAR CONTRATO
    When CLICK BOTON VALIDAR Y VER CONTRATO "<caso_prueba>"
    And GENERAMOS RECIBO DE PAGO
    And GUARDAMOS COMPRA "<caso_prueba>"
    Then SE GENERA LA ORDEN

    Examples:
      | caso_prueba |
      |           1 |
