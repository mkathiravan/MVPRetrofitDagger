# MVPRetrofitDagger

Model is responsible for handling all business logic, communication with backend server and database operations.
The View is responsible for displaying data to a user in the form of UI screens. In Android usually, Activity implements the View.
The Presenter is acted as a middleman between View and Model. It basically retrieves data from Model and returns it to View for display Purpose.

MVP GuideLines:
Activity, Fragment and a CustomView act as the View part of the application.
The Presenter is responsible for listening to user interactions (on the View) and model updates (database, APIs) as well as updating the Model and the View.
Generally, a View and Presenter are in a one to one relationship. One Presenter class manages one View at a time.
Interfaces need to be defined and implemented to communicate between View-Presenter and Presenter-Model.
The Presenter is responsible for handling all the background tasks. Android SDK classes must be avoided in the presenter classes.
The View and Model classes can’t have a reference of one another.

Dependency Injection(Dagger 2)

Annotations

i) @Module: This is used on the class does constructing objects that will be eventually provided as dependencies.

ii) @Provides: This is used on the methods inside the module class that will return the objects.

iii) @Inject: This is used upon a constructor, field or method indicates that dependency has been requested.

iv) @Component: This module class does not provide the dependency directly to the class that requesting it. For this, a component is an interface between @Module and @Inject.

v) @Singleton: This indicates that only a single instance of the dependency object would be created. 


![image](https://user-images.githubusercontent.com/39657409/64908460-37ff9c00-d71e-11e9-8fee-24f1e26ef31b.png)

![image](https://user-images.githubusercontent.com/39657409/64908472-4d74c600-d71e-11e9-9972-016cc1de5085.png)

![image](https://user-images.githubusercontent.com/39657409/64908478-5b2a4b80-d71e-11e9-97ed-1f5331ab7ac2.png)
