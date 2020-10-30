Feature: Altas_Residenciales

  @ALTA_COMBO
  Scenario Outline: Alta Residencial
    Given INGRESAMOS A LA URL MCSS "<caso_prueba>"
    When INGRESAMOS USUARIO A MCSS"<caso_prueba>"
    And INGRESAMOS CONTRASEÑA A MCSS"<caso_prueba>"
    Then INGRESO CORRECTO A LA PAGINA
    Examples:
      | caso_prueba |
      |           1 |
