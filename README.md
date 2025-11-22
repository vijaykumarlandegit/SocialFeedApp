# SocialFeedApp
Social media feed app assignment for Pribex Tech - Kotlin Compose + Spring Boot

Root of repo contains-
/frontend-appAndroid client source code (Kotlin/Compose/Hilt).
/backend-apiSpring Boot server source code (Java).
app-debug.apkThe installable Debug APK for the Android client.
social_feed_video.mp4Short screen recording of the full app flow.

# Backend Setup & Instructions
The backend is built with Spring Boot and uses in-memory data storage (data resets on server restart).

Action                 Details
Configuration      Server runs on Port 8080 and Address 0.0.0.0.
To Run             Execute the BackendApiApplication.java file.
Networking         The host machine's firewall must allow inbound TCP traffic on Port 8080 for device connectivity.

# API Structure
Endpoint	           Method	              Function
/posts	              GET	             Retrieves the list of all posts.
/posts                POST             Creates and saves a new post.

# Application Screenshots
![Login Screenshot]([https://private-user-images.githubusercontent.com/119649718/517742397-66915bc3-e24a-48f7-a3b7-21682e425bb2.jpg](https://private-user-images.githubusercontent.com/119649718/517742397-66915bc3-e24a-48f7-a3b7-21682e425bb2.jpg?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjM4MzY2NjUsIm5iZiI6MTc2MzgzNjM2NSwicGF0aCI6Ii8xMTk2NDk3MTgvNTE3NzQyMzk3LTY2OTE1YmMzLWUyNGEtNDhmNy1hM2I3LTIxNjgyZTQyNWJiMi5qcGc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUxMTIyJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MTEyMlQxODMyNDVaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT02MzlmNjU1MjMwMmVmMzkxYTNlYzkxYzU2M2UyYmFkZDYzODBlMThjYzI1YThiMWQ2YjMzZTA1OTYxZmYwYWE0JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.G0KLbJ6-um2BCsoIT0mj-xSKVeXFpce-RSWSE0beG2I))
 

# Architecture Diagram
The application uses a Client-Server Architecture with MVVM on the Android client side.
 - Client Flow: Composable (View) ↔ ViewModel ↔ PostRepository ↔ Retrofit ↔ Backend API.
 - The Repository acts as the single source of truth, abstracting data fetching from the API.

 # Time Taken & Challenges
Section	                   Detail
Time Taken	         ~4 hours for core implementation and debugging.
Challenge 1	         EPERM Socket Failure (on Android). Fix: Added <uses-permission android:name="android.permission.INTERNET" /> to the Manifest.
Challenge 2        	"Failed to connect" (on physical device). Fix: Configured the laptop's firewall to allow inbound TCP traffic on Port 8080.
Challenge 3	         Pushing large files (APK/Video) to Git. Fix: Used the Git command line (git add, git commit, git push) for reliable transfer.
