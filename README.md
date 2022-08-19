# RandM Многомодульное приложение с пагинацией, работающее с REST api https://rickandmortyapi.com/documentation/#introduction

Стек: Kotlin + Coroutines + Flow, Clean Architecture, MVVM, Android Jetpack(Navigation, Paging3), Picasso, DataBinding, Dagger 2, Retrofit2/OkHttp, GSON

В приложении есть 2 экрана. 1 экран - отображение списка персонажей Рик и Морти, используя соотвутсвующий метод api. Для каждого персонажа в ячейке списка отображается имя, раса, пол, аватарка. По тапу на ячейку списка отрывается экран детальной информации о персонаже (2 экран). При открытии детальной информации происходит загрузка, используя соответсвующий метод api. На экране детальной информации отображается имя, раса, пол, статус, аватарка, последнее известное местоположение, кол-во эпизодов, в которых упоминался персонаж.