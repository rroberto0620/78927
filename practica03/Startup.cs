using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

using icalculadora;
using calculadora;
using SoapCore;
using Microsoft.Extensions.DependencyInjection.Extensions;

using imensajes;
using mensajes;

namespace practica03
{
    public class Startup
    {
        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddSoapCore();
            services.TryAddSingleton<iCalculadora, Calculadora>();
            services.TryAddSingleton<iMensajes, Mensajes>();
            services.AddMvc();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseRouting();

            // app.UseEndpoints(endpoints =>
            // {
                // endpoints.MapGet("/", async context =>
                // {
                //     // Calculadora c = new Calculadora();
                //     // Console.WriteLine (c.suma(3,4));
                //     // await context.Response.WriteAsync(""+c.suma(3,7));
                //     await context.Response.WriteAsync("Hello World");
                // });
            // });

            app.UseEndpoints(endpoints => {
				endpoints.UseSoapEndpoint<iCalculadora>("/calculadora.svc", new SoapEncoderOptions(), SoapSerializer.DataContractSerializer);
				endpoints.UseSoapEndpoint<iMensajes>("/mensajes.svc", new SoapEncoderOptions(), SoapSerializer.XmlSerializer);
			});
        }
    }
}
