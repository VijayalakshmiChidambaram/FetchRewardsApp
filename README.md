Basic version of FetchRewardsApp

Overview
This is a native Android app built using Kotlin that fetches and displays data from a given JSON API (https://fetch-hiring.s3.amazonaws.com/hiring.json). The app processes and presents the data while adhering to clean architecture principles.

Features
Fetch data from a remote API using Retrofit and Moshi.
Filter out invalid data (items with null or blank name).
Group data by listId and sort by listId and name.
Display the results in a structured list using RecyclerView.
Dependency Injection implemented with Hilt.
MVVM architecture for separation of concerns.

Technologies Used
Kotlin: Primary language.
MVVM: Architecture pattern.
Retrofit: API calls.
Moshi: JSON serialization/deserialization.
RecyclerView: Displaying data in a list.
Hilt: Dependency injection.
LiveData: Observing data in the ViewModel.
Coroutine/Flow: Asynchronous programming

![FetchRewards](https://github.com/user-attachments/assets/853ee39d-4c6c-4d21-8f43-5df9d62a294e)
