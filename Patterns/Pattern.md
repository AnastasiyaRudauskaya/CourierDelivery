# CourierDelivery

## DesignPatterns
При реализации данного проекта были использованы паттерны проектирования. Ниже приводится объяснение некоторых из них:

### Command
В проекте был использован шаблон проектирования Command.
При работе с приложением пользователь выполняет различные операции, в ответ система всегда должна знать, где находятся данные для ее выполнения и какие действия следует выполнить. Все данные, необходимые для выполнения операции можно объединить в один объект, который и будет определять действие, или, по иному, команду.
Основной интерфейс объекта-команды определяется в интерфейсе ActionCommand и в общем случае представлен одним методом execute(). Подклассы определяют конкретного исполнителя запроса, методы execute() которых обращаются к требуемой операции бизнес-логики.

![Command](https://github.com/AnastasiyaRudauskaya/CourierDelivery/blob/master/Patterns/Images/ActionCommand.PNG)

![CommandImpl1](https://github.com/AnastasiyaRudauskaya/CourierDelivery/blob/master/Patterns/Images/LoginCommand.PNG)

![CommandImpl2](https://github.com/AnastasiyaRudauskaya/CourierDelivery/blob/master/Patterns/Images/LogoutCommand.PNG)

### Singletone
Данный паттерн очень популярен при разработке ПО. Гарантирует существование только одного экземпляра класса. В проекте Singletone реализован при помощи enum

![Enum](https://github.com/AnastasiyaRudauskaya/CourierDelivery/blob/master/Patterns/Images/daoImpl.PNG)

### Proxy 

Proxy (Заместитель) - объект, который является посредником между двумя другими объектами, и который реализует/ограничивает доступ к объекту, к которому обращаются через него. 
В данном проекте он используется при создании пула соединений для предотвращения изменения числа доступных соединений.

![Proxy](https://github.com/AnastasiyaRudauskaya/CourierDelivery/blob/master/Patterns/Images/Proxy.PNG)

### Интерфейс DAO

Также в проекте был реализован интерфейс DAO. Этот шаблон проектирования применим ко множеству языков программирования, большинству программного обеспечения, нуждающемуся в хранении информации и к большей части баз данных, но традиционно этот шаблон связывают с приложениями на платформе Java, взаимодействующими с реляционными базами данных через интерфейс JDBC. DAO абстрагирует сущности системы и делает их отображение на БД, определяет общие методы использования соединения, его получение, закрытие и возвращение в Connection Pool.

![DAO](https://github.com/AnastasiyaRudauskaya/CourierDelivery/blob/master/Patterns/Images/dao.PNG)

![DAO](https://github.com/AnastasiyaRudauskaya/CourierDelivery/blob/master/Patterns/Images/daoImpl.PNG)

