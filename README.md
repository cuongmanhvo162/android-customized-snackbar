# Android Customized Snackbar

If you never heard about Snackbar, this <a href="goo.gl/QsXJmI">link</a> could provide you full description about Snackbar. According to Google, the core concept about Snackbar is, that will give feedback about an operation. It will display a short message to notify user or provide an action to let the user response to an operation.

My project at my company currently implemented this feature. We will display a brief message on the top of the screen when ever user finished any operation on the screen. Came up with that idea, I created a customized view which I can re-use in every screens. So, this github will contain source code that demonstrate how to implement it.

Also, I really want to discuss about this design and the experience that I observe when user came to face this feature when they are using our app. If you take a look into the source code, I hope that you will easily to understand with my implementation(structured in MVP). And, somehow that could help you and I think is good to create your own customized snackbar because you will easily to modify it and implement it in your way.

This design put customized snackbar on the top, so 90% that will immediately aware your user whenever it appears to user. The feeling for user when using the app which implemented this design instead of a standard dialog actually have difference looks and feel. From my personal view but I guess some of the others would agree with me that whenever the app throws the dialog into your face, the feeling is a just little bit less comfy, and sometime it is merely storm into my mind "Did I do something wrong."

It is more fun and could make more engagement between the user and your app by implemented appearance/closed animation for the snackbar. Put some shadow and make the snackbar's corner rounded. Swipe left, right or from bottom to top to dismiss the snackbar. These stuff will make your app significant to be unique.

User may have another action while the app in process and customized snackbar being displayed and it could lead to unexpected result and might be generate error. To handle that case, I think we just need to disbale all touch of the screen. But, in case you want user have cancel-able rights we could implement interaction for it such as button or an icon. Therefore that will required more space on the snackbar and may decrease the length of the message. I think that is good to have one line placed horizontal for the content of the snackbar.  In my observation about this UX, we should have delay time for customized snackbar appearance after the app finished any process, lets your user actually aware what happened and avoid FOMO(fear of missing out).

Here are some videos

Signup successfully
https://streamable.com/t6ha4

Login successfully
https://streamable.com/pxjop

Login failed
https://streamable.com/3oscs
