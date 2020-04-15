 let i=0;
 $(document).ready(function () {
        $("#sidebar").mCustomScrollbar({
            theme: "minimal"
        });

        $('#dismiss, .overlay').on('click', function () {
            // hide sidebar
            $('#sidebar').removeClass('active');
            // hide overlay
            $('.overlay').removeClass('active');
        });

        $('#sidebarCollapse').on('click', function () {
            // open sidebar
            i++;
            if (!i%2==0) {
            	 $('#sidebar').addClass('active');
            }else{
            	$('#sidebar').removeClass('active');
            }
           
            // fade in the overlay
            
        });
    });
