# Food Recipe App

| ![Logo](https://github.com/Rodinamomen/RecipeApp/assets/96385247/ddae438a-fd52-412f-b65b-0f734050f990) | **About**<br>Food is a recipe app that helps you find the recipes you want, provides step-by-step instructions, and allows you to add or remove recipes from your favorites list. |
|:--:|--|

## Features
- Splash screen
- Signup
- Login
- Home screen with recipes
- Details screen to view recipe
- Adding recipe to favorites List

  ## ScreenShots
  <h1>Splash screen</h1>
<div style="display: flex; align-items: center;">
    <div style="flex: 1;">
        <img src="https://github.com/Rodinamomen/RecipeApp/assets/96385247/bbfa3a3a-2123-4221-91e3-1eeb23239064" alt="Splash Screen" style="width: 200px; margin-right: 20px;">
    </div>
    <div style="flex: 2;">
        <p>- Implemented using the Splash Screen API with the resized logo to the appropriate dimensions.</p>
    </div>
</div>
<h1>Signup</h1>
<div style="display: flex; align-items: center;">
    <div style="flex: 1; text-align: center;">
        <img src="https://github.com/Rodinamomen/RecipeApp/assets/96385247/dba9dff1-4724-4f92-b343-8561a9cea263" alt="SignUp" style="width: 200px; margin-right: 20px;">
        <p>- Users can sign up using their email and set a password, with an option to re-enter the password for confirmation. If the user has previously signed up, they will be directed to the login screen.</p>
    </div>
   <div style="flex: 1; text-align: center;">
  <img src="https://github.com/Rodinamomen/RecipeApp/assets/96385247/c7beb858-6067-4658-9d1d-8e57ab5c3f31" alt="SignUp" style="width: 200px; margin-right: 20px;">
         <p>- To sign up successfully, users must ensure that their password is at least 8 characters long and all fields are filled out. Additionally, the email must be in the correct format. The password entered must match the re-entered password to complete the signup process.</p>
        <h3>Technologies Used:</h3> <p>- FirebaseAuth - Firestore - Room Database</p>
    </div>
</div>
<h1>Home Screen</h1>
<div style="display: flex; align-items: center;">
    <div style="flex: 1; text-align: center;">
        <img src="https://github.com/Rodinamomen/RecipeApp/assets/96385247/e8e4f61d-1a54-4e34-88bb-d5ef3ff07ace" alt="HomeScreen" style="width: 200px; margin-right: 20px;">
        <p>-The HomeScreen displays recipes fetched from an API, with the list randomized upon each refresh.</p>
       <h3>Technologies Used:</h3><p>-Retrofit</p>
    </div>
</div>
<h1>Details Screen</h1>
<div style="display: flex; align-items: center;">
    <div style="flex: 1; text-align: center;">
        <img src="https://github.com/Rodinamomen/RecipeApp/assets/96385247/a8e20b1a-11e4-4c5c-959a-c0202f1efe4f" alt="DetailsScreen" style="width: 200px; margin-right: 20px;">
      <img src="https://github.com/Rodinamomen/RecipeApp/assets/96385247/f67856e3-9e30-4aee-8df5-fd5259660577" alt="DetailsScreen" style="width: 200px; margin-right: 20px;">
        <p>-The screen features an image and title of the recipe, accompanied by a scrollable text view. Users can add or remove the recipe from their favorites by clicking on a heart icon.</p>
       <h3>Technologies Used:</h3><p>-Room Database (utilizing many-to-many relationships)</p>
    </div>
</div>
<h1>Application Architecture</h1>
<div style="display: flex; align-items: center;">
    <div style="flex: 1; text-align: center;">
         <p>- MVVM(Model-View-ViewModel)</p>
         <p>- Repository design pattern</p>
</div>
<h1>DataBases</h1>
<div style="display: flex; align-items: center;">
    <div style="flex: 1; text-align: center;">
         <p>- FireBase Email&Password Auth</p>
         <p>- FireBase FireStore</p>
          <p>- Room database</p>
</div>
<h1>Libraires</h1>
<div style="display: flex; align-items: center;">
    <div style="flex: 1; text-align: center;">
         <p>- Retrofit</p>
         <p>- Glide</p>
        <p>- Navigation Components</p>
</div>
<h1>Language</h1>
<div style="display: flex; align-items: center;">
    <div style="flex: 1; text-align: center;">
        <img src="https://github.com/Rodinamomen/RecipeApp/assets/96385247/d3fa429f-5365-4911-9ac1-1e7c28ba19d9" alt="Kotlin" style="width: 50px; margin-right: 20px;">
        <p>-Kotlin</p>
    </div>
</div>

