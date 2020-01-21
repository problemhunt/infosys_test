Android Proficiency Exercise
Specification
MVP  architectural pattern.
This App Ingests a json feed from https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json 
 The feed contains a title and a list of rows. 
 Third party apis such as Retrofit, Gson and Picasso are used
The content is displayed (including image, title and description) in a ListView  The title in the ActionBar is updated from the json data. 
 Each row should is dynamically sized to the right height to display its content - no clipping, no extraneous white-space etc. This means some rows will are larger than others.
Loaded the images lazily (Used Picasso library for that).
Implemented pull to refresh function allowing the data & view to be updated
Non blocking UI while the data is being loaded.
