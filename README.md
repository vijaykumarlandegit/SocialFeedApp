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

#API Structure
Endpoint	           Method	              Function
/posts	              GET	             Retrieves the list of all posts.
/posts                POST             Creates and saves a new post.

#Application Screenshots


#Architecture Diagram
The application uses a Client-Server Architecture with MVVM on the Android client side.
 - Client Flow: Composable (View) ↔ ViewModel ↔ PostRepository ↔ Retrofit ↔ Backend API.
 - The Repository acts as the single source of truth, abstracting data fetching from the API.

 #Time Taken & Challenges
Section	                   Detail
Time Taken	         ~4 hours for core implementation and debugging.
Challenge 1	         EPERM Socket Failure (on Android). Fix: Added <uses-permission android:name="android.permission.INTERNET" /> to the Manifest.
Challenge 2        	"Failed to connect" (on physical device). Fix: Configured the laptop's firewall to allow inbound TCP traffic on Port 8080.
Challenge 3	         Pushing large files (APK/Video) to Git. Fix: Used the Git command line (git add, git commit, git push) for reliable transfer.
