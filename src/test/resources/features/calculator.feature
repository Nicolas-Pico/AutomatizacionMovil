Feature: Mathematical operations on the calculator

  @calculator
  Scenario Outline: Mathematical operations on the calculator
    Given i am in the application calculator <Fila>
      | Ruta Excel                        | Pestana        |
      | src/test/resources/data/data.xlsx | operacionesCal |
    When i enter the operations to be carried out
    Then it will be validated that the result is correct

    Examples:
      | Fila |
      | 1    |
      | 2    |
      | 3    |
