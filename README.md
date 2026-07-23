# taller11-Casos_Prueba
Taller 11 

|Clase           |ID    |Método              |Datos de entrada                  |Salida esperada                     |Propósito                                       |
|                |      |                    |                                  |                                    |                                                |
|ReservasService |      | reservarAsientos() |Reservar A1 y A2                  |Retorna 9.5 y ocupa ambos asientos  | Verificar una reserva válida.                  |
|ReservasService |      | reservarAsientos() |Reservar exactamente 6 asientos   |Retorna 43.35                       | Verificar el caso límite del máximo permitido. |
|ReservasService |      | reservarAsientos() |Intentar reservar 7 asientos      |Se lanza `IllegalArgumentException` | Verificar que no se exceda el máximo permitido.|